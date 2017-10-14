/*
 * navbar.component.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.less'],
})

export class NavBarComponent implements OnInit {

  menuItems = [
    'Item 1',
    'Item 2',
    'Item 3'
  ];

  ngOnInit() {
  }

  constructor() {
  }
}
