/*
 * brand.component.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-brand',
  templateUrl: './brand.component.html',
  styleUrls: ['./brand.component.less'],
})

export class NavBarBrandComponent implements OnInit {

  name = 'Risky Solid Hydrogen';
  url = 'http://www.riskysolidhydrogen.com';

  ngOnInit() {
  }

  constructor() {
  }
}
