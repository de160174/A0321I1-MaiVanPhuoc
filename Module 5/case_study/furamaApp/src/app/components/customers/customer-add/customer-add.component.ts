import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {
  public formAdd: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1920, 0, 1);
  constructor(public formBuilder: FormBuilder, public customerService: CustomerService, public router: Router) { }

  ngOnInit(): void {
    this.formAdd = this.formBuilder.group({
      fullName: ['', [Validators.required]],
      birthDay: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      identity: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      // tslint:disable-next-line:max-line-length
      phone: ['', [Validators.required, Validators.pattern('^090[0-9]{7}|091[0-9]{7}|[\(]84[\)][\+]90[0-9]{7}$|[\(]84[\)][\+]91[0-9]{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      customerType: ['', [Validators.required]],
      address: ['', [Validators.required]]
    });
  }

  addNewCustomer() {
    this.customerService.addNewCustomer(this.formAdd.value).subscribe(data => {
      this.router.navigateByUrl('/customerList');
    });
  }
}
