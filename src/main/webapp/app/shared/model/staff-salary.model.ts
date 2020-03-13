import { IStaff } from 'app/shared/model/staff.model';

export interface IStaffSalary {
  id?: number;
  salaryPaid?: number;
  month?: string;
  salaries?: IStaff[];
}

export class StaffSalary implements IStaffSalary {
  constructor(public id?: number, public salaryPaid?: number, public month?: string, public salaries?: IStaff[]) {}
}
