import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {CustomerService} from '../../../services/customer.service';
import {EmployeeService} from '../../../services/employee.service';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {
  public employeeName;
  public employeeId;

  constructor(public dialogRef: MatDialogRef<EmployeeDeleteComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any,
              public employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeName = this.data.name.fullName;
    this.employeeId = this.data.name.id;
  }

  deleteEmployee() {
    this.employeeService.deleteEmployee(this.employeeId).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
