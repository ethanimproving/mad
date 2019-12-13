import React from 'react';
import { MovieList } from './MovieList';
import { MovieDetails } from './MovieDetails';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {
  return <>
  <Router>
    <Switch>
      <Route exact path="/" component={ MovieList }/>
      <Route path="/movie/:movieId" component={ MovieDetails }/>
    </Switch>
  </Router>
</>;
}

export default App;
