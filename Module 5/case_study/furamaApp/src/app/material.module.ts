import { NgModule } from '@angular/core';
import { MatDatepickerModule, MatNativeDateModule, MatFormFieldModule, MatInputModule, MatDialogModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CustomerDeleteComponent} from './components/customers/customer-delete/customer-delete.component';

@NgModule({
  imports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  exports: [
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [ MatDatepickerModule ],
  entryComponents: [CustomerDeleteComponent]
})

export class MaterialModule { }
