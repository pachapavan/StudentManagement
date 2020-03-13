import { IStudent } from 'app/shared/model/student.model';
import { ISubject } from 'app/shared/model/subject.model';

export interface IStudentMarkes {
  id?: number;
  examName?: string;
  totalMarkes?: number;
  markes?: number;
  comments?: string;
  student?: IStudent;
  subject?: ISubject;
}

export class StudentMarkes implements IStudentMarkes {
  constructor(
    public id?: number,
    public examName?: string,
    public totalMarkes?: number,
    public markes?: number,
    public comments?: string,
    public student?: IStudent,
    public subject?: ISubject
  ) {}
}
