export class MovieListPage{
  constructor() {  }

  visit() {
    cy.visit('/');
  }

  getSearchTitle() {
    return cy.get('#root > div:nth-child(2) > div > h3');
  }

  getNewMovieButton() {
    return cy.get('#root > div.findSection > div > a:nth-child(2)');
  }

}