import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CountdownTimerAliasComponent } from './countdown-timer-alias/countdown-timer-alias.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimerAliasComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
