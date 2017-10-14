/*
 * contact.component.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Component, Inject, OnInit, AfterViewInit } from '@angular/core';

@Component({
    selector: 'app-contact-content',
    templateUrl: './contact.component.html',
    styleUrls: ['./content.album.css']
})

export class ContactComponent implements OnInit, AfterViewInit {
    title = 'Lavish Duck';

    constructor() {
    }

    ngOnInit() {
    }

    ngAfterViewInit() {
    }
}
