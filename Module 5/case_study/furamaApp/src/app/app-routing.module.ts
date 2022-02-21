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


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customerList', component: CustomerListComponent},
  {path: 'customerAdd', component: CustomerAddComponent},
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
  declarations: [CustomerListComponent, HomeComponent, ErrorComponent, CustomerAddComponent, CustomerDeleteComponent]
})
export class AppRoutingModule {
}
