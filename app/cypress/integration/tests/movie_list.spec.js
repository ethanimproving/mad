describe('movie_list', () => {
  it('should load', () => {
    cy.visit('/')
    cy.get('#root > div:nth-child(2) > div > h3').contains('Search For Any Movie')
  })

  it('should add new movie', () => {
    // Add new movie
    cy.get('#root > div.findSection > div > a:nth-child(2)').click()

    // Validate page was hit
    cy.url().should('include', '/new')

    // Fill out form
    cy.get('#title').type('My New Movie')
    cy.get('#year').type('2020')
    cy.get('#rating').type('9')
    cy.get('#runTime').type('102')

    // Submit form
    cy.get('#root > form > div:nth-child(6) > button').click()

    // Check for new movie
    cy.get('#movies').contains('My New Movie')

  })
})