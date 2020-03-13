import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { StudentManagementSharedModule } from 'app/shared/shared.module';
import { StudentFeeComponent } from './student-fee.component';
import { StudentFeeDetailComponent } from './student-fee-detail.component';
import { StudentFeeUpdateComponent } from './student-fee-update.component';
import { StudentFeeDeleteDialogComponent } from './student-fee-delete-dialog.component';
import { studentFeeRoute } from './student-fee.route';

@NgModule({
  imports: [StudentManagementSharedModule, RouterModule.forChild(studentFeeRoute)],
  declarations: [StudentFeeComponent, StudentFeeDetailComponent, StudentFeeUpdateComponent, StudentFeeDeleteDialogComponent],
  entryComponents: [StudentFeeDeleteDialogComponent]
})
export class StudentManagementStudentFeeModule {}
