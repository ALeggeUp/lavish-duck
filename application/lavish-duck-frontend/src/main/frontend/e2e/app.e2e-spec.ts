import { LavishDuckPage } from './app.po';

describe('lavish-duck App', () => {
  let page: LavishDuckPage;

  beforeEach(() => {
    page = new LavishDuckPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
