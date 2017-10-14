/*
 * intro.component.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Component, Inject, OnInit, AfterViewInit } from '@angular/core';

@Component({
    selector: 'app-intro-content',
    templateUrl: './intro.component.html',
    styleUrls: ['./intro.component.css']
})

export class IntroComponent implements OnInit, AfterViewInit {
    title = 'Lavish Duck';
    subtitle = '';

    constructor() {
    }

    ngOnInit() {
    }

    ngAfterViewInit() {
    }

    scratch() {
        alert('app-component-scratch');
    }
}
