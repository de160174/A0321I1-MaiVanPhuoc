import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../services/customer.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  public formEdit: FormGroup;
  public customer;
  public customerTypes;
  public customerType;
  public id;
  public name;
  public maxDate = new Date();
  public minDate = new Date(1920, 0, 1);

  constructor(public formBuilder: FormBuilder,
              public customerService: CustomerService,
              public router: Router,
              public activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerType().subscribe(data => {
      this.customerTypes = data;
    });
    this.formEdit = this.formBuilder.group({
      fullName: ['', [Validators.required]],
      birthDay: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      identity: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      // tslint:disable-next-line:max-line-length
      phone: ['', [Validators.required, Validators.pattern('^090[0-9]{7}|091[0-9]{7}|[\(]84[\)][\+]90[0-9]{7}$|[\(]84[\)][\+]91[0-9]{7}$')]],
      email: ['', [Validators.required, Validators.email]],
      customerType: this.formBuilder.group({
        id: [''],
        name: ['', [Validators.required]]
      }),
      address: ['', [Validators.required]]
    });
    this.activatedRoute.params.subscribe(data => {
      this.customer = data.id;
      this.customerService.getCustomerById(this.customer).subscribe(data1 => {
        this.formEdit.patchValue(data1);
      });
    });
  }

  editCustomer() {
    this.customerService.editCustomer(this.customer, this.formEdit.value).subscribe(data => {
      this.router.navigateByUrl('customerList');
    });
  }

  onChange(value: any) {
    this.customerType = JSON.parse(value);
    this.id = this.customerType.id;
    this.name = this.customerType.name;
  }
}
