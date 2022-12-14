import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProcessBarComponent } from './process-bar/process-bar.component';

@NgModule({
  declarations: [
    AppComponent,
    NameCardComponent,
    ProcessBarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
