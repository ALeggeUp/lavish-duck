/*
 * metamask.service.ts
 *
 * Copyright (C) 2017 Stephen Legge, Tim McCrabb and Andy Redfearn
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */

import { Injectable, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/timer';
import 'rxjs/add/observable/fromPromise';

@Injectable()
export class MetaMaskService {

    private web3Instance : any;
    private account : string;

    @Output()
    accountChange: EventEmitter<string> = new EventEmitter();

    @Output() update = new EventEmitter();

    constructor() {
        Observable.timer(500, 1000).subscribe((value) => this.refresh(value, false));
    }

    refresh(value: number, force: boolean): void {
        this.Web3Promise().then((web3) => {
            return this.getAccounts(web3);
        }).then((accounts) => {
            this.account = accounts[0];
            if (force || !localStorage['lastAccount'] || localStorage['lastAccount'] !== this.account) {
                localStorage['lastAccount'] = this.account;
                this.accountChange.emit(this.account);
            }
        });
    }

    getAccounts(web3: any): Promise<any> {
        return new Promise(function(resolve, reject) {
            web3.eth.getAccounts(function(err, data) {
                if(err !== null) {
                    return reject(err);
                }
                resolve(data);
            });
        });
    }

    getAccountChangeEmitter() {
        return this.accountChange;
    }

    isConnected(): boolean {
        return (typeof window['web3'] !== 'undefined');
    }

    Web3Promise(): Promise<any> {
        return new Promise((resolve, reject) => {
            resolve(this.waitForWeb3());
        });
    }

    waitForWeb3(): any {
        while(typeof window['web3'] === 'undefined') {
            console.log('waiting for web3');
        }

        return new this.Web3(window['web3'].currentProvider);
    }

    get Web3(): any {
        return window['Web3'];
    }
}