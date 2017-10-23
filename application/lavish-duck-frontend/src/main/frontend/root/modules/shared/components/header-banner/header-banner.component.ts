/*
 * header-banner.component.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Input, Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-header-banner',
    templateUrl: './header-banner.component.html',
    styleUrls: ['./header-banner.component.css'],
})

export class HeaderBannerComponent implements OnInit {

    @Input() subtitle: string;

    title = 'Lavish Duck';

    constructor() {
    }

    ngOnInit() {
    }
}
