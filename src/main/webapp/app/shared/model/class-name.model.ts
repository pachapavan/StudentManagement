import { IStudent } from 'app/shared/model/student.model';
import { IStaff } from 'app/shared/model/staff.model';

export interface IClassName {
  id?: number;
  name?: string;
  classNumber?: number;
  classes?: IStudent[];
  staff?: IStaff;
}

export class ClassName implements IClassName {
  constructor(public id?: number, public name?: string, public classNumber?: number, public classes?: IStudent[], public staff?: IStaff) {}
}
