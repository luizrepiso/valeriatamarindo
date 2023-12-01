import UserCrudCard from 'components/UserCrudCard';
import { Link } from 'react-router-dom';
import { useCallback, useEffect, useState } from 'react';
import { SpringPage } from 'types/vendor/spring';
import { User } from 'types/user';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';
import Pagination from 'components/Pagination';
import UserFilter, { UserFilterData } from 'components/UserFilter';

import './styles.css';

type ControlComponentsData = {
  activePage: number;
  filterData: UserFilterData;
};

const UserList = () => {
  const [page, setPage] = useState<SpringPage<User>>();

  const [controlComponentsData, setControlComponentsData] =
    useState<ControlComponentsData>({
      activePage: 0,
      filterData: { name: '', role: null },
    });

  const handlePageChange = (pageNumber: number) => {
    setControlComponentsData({
      activePage: pageNumber,
      filterData: controlComponentsData.filterData,
    });
  };

  const handleSubmitFilter = (data: UserFilterData) => {
    setControlComponentsData({
      activePage: 0,
      filterData: data,
    });
  };

  const getUsers = useCallback(() => {
    const config: AxiosRequestConfig = {
      method: 'GET',
      url: '/users',
      withCredentials: true,
      params: {
        page: controlComponentsData.activePage,
        size: 3,
        name: controlComponentsData.filterData.name,     
      },
    };
    requestBackend(config).then((response) => {
      setPage(response.data);
    });
  }, [controlComponentsData]);

  useEffect(() => {
    getUsers();
  }, [getUsers]);

  return (  

    <div className="user-crud-container">      
      <div className="user-crud-bar-container">
        <Link to="/admin/users/create">
          <button className="btn btn-danger text-#961417 btn-crud-add">
            ADICIONAR
          </button>
        </Link>
        <UserFilter onSubmitFilter={handleSubmitFilter} />
      </div>
      <div className="row">
        {page?.content.map((user) => (
          <div key={user.id} className="col-sm-6 col-md-12">
            <UserCrudCard user={user} onDelete={getUsers} />
          </div>
        ))}
      </div>
      <Pagination
        forcePage={page?.number}
        pageCount={(page) ? page.totalPages : 0}
        range={3}
        onChange={handlePageChange}
      />
    </div>
   
    
  );
};
export default UserList;
