import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from './components/customers/customer-list/customer-list.component';
import {HomeComponent} from './components/home/home.component';
import {ErrorComponent} from './components/error/error.component';
import {CommonModule} from '@angular/common';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerAddComponent } from './components/customers/customer-add/customer-add.component';
import {MaterialModule} from './material.module';
import { CustomerDeleteComponent } from './components/customers/customer-delete/customer-delete.component';
import { CustomerEditComponent } from './components/customers/customer-edit/customer-edit.component';
import { EmployeeListComponent } from './components/employees/employee-list/employee-list.component';
import { EmployeeAddComponent } from './components/employees/employee-add/employee-add.component';
import { EmployeeEditComponent } from './components/employees/employee-edit/employee-edit.component';
import { EmployeeDeleteComponent } from './components/employees/employee-delete/employee-delete.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customerList', component: CustomerListComponent},
  {path: 'customerAdd', component: CustomerAddComponent},
  {path: 'customerEdit/:id', component: CustomerEditComponent},
  {path: 'employeeList', component: EmployeeListComponent},
  {path: 'employeeAdd', component: EmployeeAddComponent},
  {path: 'employeeEdit/:id', component: EmployeeEditComponent},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule,
    Ng2SearchPipeModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    MaterialModule
  ],
  exports: [RouterModule],
  entryComponents: [CustomerDeleteComponent],
  declarations: [CustomerListComponent,
    HomeComponent,
    ErrorComponent,
    CustomerAddComponent,
    CustomerDeleteComponent,
    CustomerEditComponent,
    EmployeeListComponent,
    EmployeeAddComponent,
    EmployeeEditComponent,
    EmployeeDeleteComponent]
})
export class AppRoutingModule {
}
