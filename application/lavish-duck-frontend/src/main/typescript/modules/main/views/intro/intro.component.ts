/*
 * intro.component.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Component, Inject, OnInit, AfterViewInit } from '@angular/core';

import { MetaMaskService } from '../../services/metamask.service';

@Component({
    selector: 'app-intro-content',
    templateUrl: './intro.component.html',
    styleUrls: ['./intro.component.css']
})

export class IntroComponent implements OnInit, AfterViewInit {

    title = 'Lavish Duck';
    subtitle = '';

    private web3: any;

    constructor(@Inject(MetaMaskService) private metaMaskService) {
    }

    ngOnInit() {
    }

    ngAfterViewInit() {
        this.metaMaskService.Web3Promise().then(web3 => {
            this.subtitle = web3.eth.accounts[0];
            console.log(web3);
            this.web3 = web3
        });
    }
}
