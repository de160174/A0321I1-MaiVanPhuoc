import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../../services/employee.service';
import {MatDialog} from '@angular/material/dialog';
import {EmployeeDeleteComponent} from '../employee-delete/employee-delete.component';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  searchName: string;
  searchEmail: string;
  public employees;
  name: string;
  page: number;

  constructor(public employeeService: EmployeeService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.employeeService.getAllEmployee().subscribe(data => {
      this.employees = data;
    });
  }

  onSearch() {
    this.employeeService.searchEmployee(this.searchName.trim(), this.searchEmail.trim()).subscribe(data => {
      this.page = 1;
      this.employees = data;
    });
  }

  openDialog(id) {
    this.employeeService.getEmployeeById(id).subscribe(dataEmployee => {
      const dialogRef = this.dialog.open(EmployeeDeleteComponent, {
        width: '500px',
        data: {name: dataEmployee},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    })
  }
}
