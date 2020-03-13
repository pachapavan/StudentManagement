import { IStudent } from 'app/shared/model/student.model';

export interface ISection {
  id?: number;
  name?: string;
  sectionNumber?: number;
  sections?: IStudent[];
}

export class Section implements ISection {
  constructor(public id?: number, public name?: string, public sectionNumber?: number, public sections?: IStudent[]) {}
}
