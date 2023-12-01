import { Route, Switch } from 'react-router-dom';
import CategoryList from './CategoryList';
import CategoryForm from './CategoryForm';

const categories = () => {
  return (
    <Switch>
      <Route path="/admin/categories" exact>
        <CategoryList />
      </Route>
      <Route path="/admin/categories/:categoryId" exact>
        <CategoryForm />
      </Route>
    </Switch>
  );
};
export default categories;
