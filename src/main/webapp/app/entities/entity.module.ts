import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'staff',
        loadChildren: () => import('./staff/staff.module').then(m => m.StudentManagementStaffModule)
      },
      {
        path: 'student',
        loadChildren: () => import('./student/student.module').then(m => m.StudentManagementStudentModule)
      },
      {
        path: 'class-name',
        loadChildren: () => import('./class-name/class-name.module').then(m => m.StudentManagementClassNameModule)
      },
      {
        path: 'section',
        loadChildren: () => import('./section/section.module').then(m => m.StudentManagementSectionModule)
      },
      {
        path: 'subject',
        loadChildren: () => import('./subject/subject.module').then(m => m.StudentManagementSubjectModule)
      },
      {
        path: 'student-markes',
        loadChildren: () => import('./student-markes/student-markes.module').then(m => m.StudentManagementStudentMarkesModule)
      },
      {
        path: 'attendence',
        loadChildren: () => import('./attendence/attendence.module').then(m => m.StudentManagementAttendenceModule)
      },
      {
        path: 'student-fee',
        loadChildren: () => import('./student-fee/student-fee.module').then(m => m.StudentManagementStudentFeeModule)
      },
      {
        path: 'bus-route',
        loadChildren: () => import('./bus-route/bus-route.module').then(m => m.StudentManagementBusRouteModule)
      },
      {
        path: 'bus-stops',
        loadChildren: () => import('./bus-stops/bus-stops.module').then(m => m.StudentManagementBusStopsModule)
      },
      {
        path: 'staff-salary',
        loadChildren: () => import('./staff-salary/staff-salary.module').then(m => m.StudentManagementStaffSalaryModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class StudentManagementEntityModule {}
