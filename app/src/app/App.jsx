import React from 'react';
import { MovieList } from './MovieList';
import { MovieDetails } from './MovieDetails';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { MovieEditor } from './MovieEditor';
import { DeletedMovies } from './DeletedMovies';

function App() {
  return <>
  <Router>
    <Switch>
      <Route exact path="/" component={ MovieList }/>
      <Route path="/movie/:movieId" component={ MovieDetails }/>
      <Route path="/movies/:movieId/edit" component={ MovieEditor }/>
      <Route path="/deleted" component={ DeletedMovies }/>
      <Route path="/new" component={ MovieEditor }/>
    </Switch>
  </Router>
</>;
}

export default App;
