import { Route, Switch } from 'react-router-dom';
import ListCat from './ListCat';
import FormCat from './FormCat';

const categories = () => {
  return (
    <Switch>
      <Route path="/admin/categories" exact>
        <ListCat />
      </Route>
      <Route path="/admin/categories/:categoryId" exact>
        <FormCat />
      </Route>
    </Switch>
  );
};
export default categories;
