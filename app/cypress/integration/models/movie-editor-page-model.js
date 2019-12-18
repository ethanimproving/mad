export class MovieEditorPage{
  constructor() {  }

  visit() {
    cy.visit('/new');
  }

  getTitle() {
    return cy.get('#title');
  }
  
  getYear() {
    return cy.get('#year');
  }
  
  getRating() {
    return cy.get('#rating');
  }
  
  getRunTime() {
    return cy.get('#runTime');
  }

  getSubmitButton() {
    return cy.get('#root > form > div:nth-child(6) > button');
  }

  getMovies() {
    return cy.get('#movies');
  }

}