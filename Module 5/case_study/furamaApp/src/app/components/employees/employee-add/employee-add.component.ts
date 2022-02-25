import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-employee-add',
  templateUrl: './employee-add.component.html',
  styleUrls: ['./employee-add.component.css']
})
export class EmployeeAddComponent implements OnInit {
  formAdd: FormGroup;
  maxDate = new Date();
  minDate = new Date(1920, 0 , 1);
  public position;
  public positions;
  public education;
  public educations;
  public division;
  public divisions;

  constructor(public formBuilder: FormBuilder,
              public employeeService: EmployeeService,
              public router: Router) { }

  ngOnInit(): void {
    this.employeeService.getAllPosition().subscribe(data => {
      this.positions = data;
    });
    this.employeeService.getAllEducation().subscribe(data => {
      this.educations = data;
    });
    this.employeeService.getAllDivision().subscribe(data => {
      this.divisions = data;
    });
    this.formAdd = this.formBuilder.group({
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
      }),
      educationDegree: this.formBuilder.group({
        id: [''],
        name: ['']
      }),
      division: this.formBuilder.group({
        id: [''],
        name: ['']
      })
    });
  }

  addEmployee() {
    this.employeeService.addEmployee(this.formAdd.value).subscribe(data => {
      this.router.navigateByUrl('employeeList');
      // this.alert();
    });
  }
  // alert(){
  //   this.toast.success('Create successfully!', 'alert');
  // }
}
