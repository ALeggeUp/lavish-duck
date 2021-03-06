/*
 * main.module.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MainRoutingModule } from './main-routing.module';
import { SharedModule } from '../shared/shared.module';

import { LoginComponent } from './views/login/login.component';
import { ContactComponent } from './views/contact/contact.component';
import { CreateComponent } from './views/create/create.component';
import { EditComponent } from './views/edit/edit.component';
import { ExistingComponent } from './views/existing/existing.component';
import { IntroComponent } from './views/intro/intro.component';
import { MoreComponent } from './views/more/more.component';

import { AuthGuardService } from './services/auth-guard.service';
import { MetaMaskService } from './services/metamask.service';
import { LoggerService } from './services/logger.service';

@NgModule({
  declarations: [
    LoginComponent,
    ContactComponent,
    CreateComponent,
    EditComponent,
    ExistingComponent,
    IntroComponent,
    MoreComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MainRoutingModule,
    SharedModule
  ],
  exports: [
  ],
  providers: [
    AuthGuardService,
    MetaMaskService,
    LoggerService
  ]
})

export class MainModule {
}
