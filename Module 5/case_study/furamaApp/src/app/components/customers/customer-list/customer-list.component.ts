import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../services/customer.service';
import {MatDialog} from '@angular/material';
import {CustomerDeleteComponent} from '../customer-delete/customer-delete.component';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers;
  search: string;
  p: any;
  name: string;
  constructor(public customerService: CustomerService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
  }

  openDialog() {
    const dialogRef = this.dialog.open(CustomerDeleteComponent, {
      width: '500px',
      data: {name: this.name},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
