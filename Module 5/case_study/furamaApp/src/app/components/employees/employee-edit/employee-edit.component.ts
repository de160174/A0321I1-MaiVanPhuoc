import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Position} from '../model/position';
import {EducationDegree} from '../model/education-degree';
import {Division} from '../model/division';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  formEdit: FormGroup;
  maxDate = new Date();
  minDate = new Date(1920, 0, 1);
  public employee;
  public position: Position;
  public education: EducationDegree;
  public division: Division;
  public positions;
  public educations;
  public divisions;

  constructor(public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.getPosition();
    this.getEducation();
    this.getDivision();

    this.formEdit = this.formBuilder.group({
      fullName: ['', [Validators.required]],
      birthDay: ['', [Validators.required]],
      identity: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      salary: ['', [Validators.required, Validators.min(0)]],
      // tslint:disable-next-line:max-line-length
      phone: ['', [Validators.required, Validators.pattern('^090[0-9]{7}|091[0-9]{7}|[\(]84[\)][\+]90[0-9]{7}$|[\(]84[\)][\+]91[0-9]{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      address: ['', [Validators.required]],
      position: this.formBuilder.group({
        id: [''],
        name: ['']
      }, [Validators.required]),
      educationDegree: this.formBuilder.group({
        id: [''],
        name: ['']
      }, [Validators.required]),
      division: this.formBuilder.group({
        id: [''],
        name: ['']
      }, [Validators.required])
    });

    this.activatedRoute.params.subscribe(data => {
      this.employee = data.id;
      this.employeeService.getEmployeeById(this.employee).subscribe(data1 => {
          this.formEdit.patchValue(data1);
        }
      );
    });
  }

  getPosition() {
    this.employeeService.getAllPosition().subscribe(data => {
      this.positions = data;
    });
  }
  getEducation(){
    this.employeeService.getAllEducation().subscribe(data => {
      this.educations = data;
    });
  }
  getDivision() {
    this.employeeService.getAllDivision().subscribe(data => {
      this.divisions = data;
    });
  }


  editEmployee() {
    this.employeeService.editEmployee(this.employee, this.formEdit.value).subscribe(data => {
      this.router.navigateByUrl('employeeList');
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
