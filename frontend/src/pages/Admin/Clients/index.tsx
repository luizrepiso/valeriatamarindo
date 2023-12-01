import { Route, Switch } from "react-router-dom";
import ClientList from "./ClientList";
import ClientForm from "./ClientForm";

const clients = () => {
  return (
    <Switch>
      <Route path="/admin/clients" exact>
        <ClientList />
      </Route>
      <Route path="/admin/clients/:clientId" exact>
        <ClientForm />
      </Route>
    </Switch>
  );
};
export default clients;
