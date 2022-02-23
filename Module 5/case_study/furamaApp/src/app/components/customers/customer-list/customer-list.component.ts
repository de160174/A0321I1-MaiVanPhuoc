import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../../services/customer.service';
import {MatDialog} from '@angular/material/dialog';
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

  openDialog(customerId) {
    // this.dialog.open(CustomerDeleteComponent);
    this.customerService.getCustomerById(customerId).subscribe(dataCustomer => {
      const dialogRef = this.dialog.open(CustomerDeleteComponent, {
        width: '500px',
        data: {name: dataCustomer},
        disableClose: true
      });

      dialogRef.afterClosed().subscribe(result => {
        this.ngOnInit();
      });
    });
  }

  onSearch() {
    this.customerService.searchCustomer(this.search.trim()).subscribe(data => {
      this.customers = data;
    });
  }
}
