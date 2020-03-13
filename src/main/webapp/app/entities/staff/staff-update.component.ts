import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IStaff, Staff } from 'app/shared/model/staff.model';
import { StaffService } from './staff.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import { IStaffSalary } from 'app/shared/model/staff-salary.model';
import { StaffSalaryService } from 'app/entities/staff-salary/staff-salary.service';

@Component({
  selector: 'jhi-staff-update',
  templateUrl: './staff-update.component.html'
})
export class StaffUpdateComponent implements OnInit {
  isSaving = false;
  staffsalaries: IStaffSalary[] = [];

  editForm = this.fb.group({
    id: [],
    staffId: [],
    staffName: [],
    phoneNumber: [],
    address: [],
    photo: [],
    photoContentType: [],
    isTeachingStaff: [],
    status: [],
    salary: [],
    staffSalary: []
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected staffService: StaffService,
    protected staffSalaryService: StaffSalaryService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ staff }) => {
      this.updateForm(staff);

      this.staffSalaryService.query().subscribe((res: HttpResponse<IStaffSalary[]>) => (this.staffsalaries = res.body || []));
    });
  }

  updateForm(staff: IStaff): void {
    this.editForm.patchValue({
      id: staff.id,
      staffId: staff.staffId,
      staffName: staff.staffName,
      phoneNumber: staff.phoneNumber,
      address: staff.address,
      photo: staff.photo,
      photoContentType: staff.photoContentType,
      isTeachingStaff: staff.isTeachingStaff,
      status: staff.status,
      salary: staff.salary,
      staffSalary: staff.staffSalary
    });
  }

  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }

  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }

  setFileData(event: Event, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.editForm, field, isImage).subscribe(null, (err: JhiFileLoadError) => {
      this.eventManager.broadcast(
        new JhiEventWithContent<AlertError>('studentManagementApp.error', { ...err, key: 'error.file.' + err.key })
      );
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const staff = this.createFromForm();
    if (staff.id !== undefined) {
      this.subscribeToSaveResponse(this.staffService.update(staff));
    } else {
      this.subscribeToSaveResponse(this.staffService.create(staff));
    }
  }

  private createFromForm(): IStaff {
    return {
      ...new Staff(),
      id: this.editForm.get(['id'])!.value,
      staffId: this.editForm.get(['staffId'])!.value,
      staffName: this.editForm.get(['staffName'])!.value,
      phoneNumber: this.editForm.get(['phoneNumber'])!.value,
      address: this.editForm.get(['address'])!.value,
      photoContentType: this.editForm.get(['photoContentType'])!.value,
      photo: this.editForm.get(['photo'])!.value,
      isTeachingStaff: this.editForm.get(['isTeachingStaff'])!.value,
      status: this.editForm.get(['status'])!.value,
      salary: this.editForm.get(['salary'])!.value,
      staffSalary: this.editForm.get(['staffSalary'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStaff>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: IStaffSalary): any {
    return item.id;
  }
}
