import { IClassName } from 'app/shared/model/class-name.model';
import { IStaffSalary } from 'app/shared/model/staff-salary.model';

export interface IStaff {
  id?: number;
  staffId?: number;
  staffName?: string;
  phoneNumber?: number;
  address?: string;
  photoContentType?: string;
  photo?: any;
  isTeachingStaff?: boolean;
  status?: string;
  salary?: number;
  teachers?: IClassName[];
  staffSalary?: IStaffSalary;
}

export class Staff implements IStaff {
  constructor(
    public id?: number,
    public staffId?: number,
    public staffName?: string,
    public phoneNumber?: number,
    public address?: string,
    public photoContentType?: string,
    public photo?: any,
    public isTeachingStaff?: boolean,
    public status?: string,
    public salary?: number,
    public teachers?: IClassName[],
    public staffSalary?: IStaffSalary
  ) {
    this.isTeachingStaff = this.isTeachingStaff || false;
  }
}
