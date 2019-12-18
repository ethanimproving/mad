/// <reference types='Cypress'/>

import { MovieListPage, MovieEditorPage } from "../models"


describe('movie_list', () => {

  beforeEach() {
    const movieList = new MovieListPage
    const movieEditor = new MovieEditorPage
  }

  it('should load', () => {
    movieList.visit();
    movieList.getSearchTitle().contains('Search For Any Movie');
  })

  it('should add new movie', () => {
    // Add new movie
    movieList.getNewMovieButton().click()

    // Validate page was hit
    cy.url().should('include', '/new')

    // Fill out form
    movieEditor.getTitle().type('My New Movie')    
    movieEditor.getYear().type('2020')
    movieEditor.getRating().type('9') 
    movieEditor.getRunTime().type('102')

    // Submit form
    // movieEditor.getSubmitButton().click()

    // Check for new movie
    movieList.visit();
    movieEditor.getMovies().contains('My New Movie')

  })
})