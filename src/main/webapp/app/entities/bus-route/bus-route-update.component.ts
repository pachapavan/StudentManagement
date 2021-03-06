import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IBusRoute, BusRoute } from 'app/shared/model/bus-route.model';
import { BusRouteService } from './bus-route.service';

@Component({
  selector: 'jhi-bus-route-update',
  templateUrl: './bus-route-update.component.html'
})
export class BusRouteUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    routeName: [],
    routeDriver: [],
    busNumber: [],
    year: [],
    status: [],
    comments: []
  });

  constructor(protected busRouteService: BusRouteService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ busRoute }) => {
      this.updateForm(busRoute);
    });
  }

  updateForm(busRoute: IBusRoute): void {
    this.editForm.patchValue({
      id: busRoute.id,
      routeName: busRoute.routeName,
      routeDriver: busRoute.routeDriver,
      busNumber: busRoute.busNumber,
      year: busRoute.year,
      status: busRoute.status,
      comments: busRoute.comments
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const busRoute = this.createFromForm();
    if (busRoute.id !== undefined) {
      this.subscribeToSaveResponse(this.busRouteService.update(busRoute));
    } else {
      this.subscribeToSaveResponse(this.busRouteService.create(busRoute));
    }
  }

  private createFromForm(): IBusRoute {
    return {
      ...new BusRoute(),
      id: this.editForm.get(['id'])!.value,
      routeName: this.editForm.get(['routeName'])!.value,
      routeDriver: this.editForm.get(['routeDriver'])!.value,
      busNumber: this.editForm.get(['busNumber'])!.value,
      year: this.editForm.get(['year'])!.value,
      status: this.editForm.get(['status'])!.value,
      comments: this.editForm.get(['comments'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IBusRoute>>): void {
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
}
