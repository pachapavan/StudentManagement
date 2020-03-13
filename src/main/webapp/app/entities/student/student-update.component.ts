import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { JhiDataUtils, JhiFileLoadError, JhiEventManager, JhiEventWithContent } from 'ng-jhipster';

import { IStudent, Student } from 'app/shared/model/student.model';
import { StudentService } from './student.service';
import { AlertError } from 'app/shared/alert/alert-error.model';
import { IClassName } from 'app/shared/model/class-name.model';
import { ClassNameService } from 'app/entities/class-name/class-name.service';
import { ISection } from 'app/shared/model/section.model';
import { SectionService } from 'app/entities/section/section.service';
import { IBusStops } from 'app/shared/model/bus-stops.model';
import { BusStopsService } from 'app/entities/bus-stops/bus-stops.service';

type SelectableEntity = IClassName | ISection | IBusStops;

@Component({
  selector: 'jhi-student-update',
  templateUrl: './student-update.component.html'
})
export class StudentUpdateComponent implements OnInit {
  isSaving = false;
  classnames: IClassName[] = [];
  sections: ISection[] = [];
  busstops: IBusStops[] = [];

  editForm = this.fb.group({
    id: [],
    studentId: [],
    studentName: [],
    parentName: [],
    phoneNumber: [],
    address: [],
    photo: [],
    photoContentType: [],
    status: [],
    comments: [],
    className: [],
    section: [],
    busStops: []
  });

  constructor(
    protected dataUtils: JhiDataUtils,
    protected eventManager: JhiEventManager,
    protected studentService: StudentService,
    protected classNameService: ClassNameService,
    protected sectionService: SectionService,
    protected busStopsService: BusStopsService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ student }) => {
      this.updateForm(student);

      this.classNameService.query().subscribe((res: HttpResponse<IClassName[]>) => (this.classnames = res.body || []));

      this.sectionService.query().subscribe((res: HttpResponse<ISection[]>) => (this.sections = res.body || []));

      this.busStopsService.query().subscribe((res: HttpResponse<IBusStops[]>) => (this.busstops = res.body || []));
    });
  }

  updateForm(student: IStudent): void {
    this.editForm.patchValue({
      id: student.id,
      studentId: student.studentId,
      studentName: student.studentName,
      parentName: student.parentName,
      phoneNumber: student.phoneNumber,
      address: student.address,
      photo: student.photo,
      photoContentType: student.photoContentType,
      status: student.status,
      comments: student.comments,
      className: student.className,
      section: student.section,
      busStops: student.busStops
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
    const student = this.createFromForm();
    if (student.id !== undefined) {
      this.subscribeToSaveResponse(this.studentService.update(student));
    } else {
      this.subscribeToSaveResponse(this.studentService.create(student));
    }
  }

  private createFromForm(): IStudent {
    return {
      ...new Student(),
      id: this.editForm.get(['id'])!.value,
      studentId: this.editForm.get(['studentId'])!.value,
      studentName: this.editForm.get(['studentName'])!.value,
      parentName: this.editForm.get(['parentName'])!.value,
      phoneNumber: this.editForm.get(['phoneNumber'])!.value,
      address: this.editForm.get(['address'])!.value,
      photoContentType: this.editForm.get(['photoContentType'])!.value,
      photo: this.editForm.get(['photo'])!.value,
      status: this.editForm.get(['status'])!.value,
      comments: this.editForm.get(['comments'])!.value,
      className: this.editForm.get(['className'])!.value,
      section: this.editForm.get(['section'])!.value,
      busStops: this.editForm.get(['busStops'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IStudent>>): void {
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

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
