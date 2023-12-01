import { ReactComponent as SearchIcon } from 'assets/images/search-icon.svg';
import { useForm } from 'react-hook-form';
import { useEffect, useState } from 'react';
import { Address } from 'types/address';
import { requestBackend } from 'util/requests';


import './styles.css';


export type ClientFilterData = {
  name: string;
  address: Address | null;
  
};

type Props = {
  onSubmitFilter: (data: ClientFilterData) => void;
};

const ClientFilter = ({ onSubmitFilter }: Props) => {
  const [selectAddresses, setSelectAddresses] = useState<Address[]>([]);

  const { register, handleSubmit, setValue, getValues, control } =
    useForm<ClientFilterData>();

  const onSubmit = (formData: ClientFilterData) => {
   onSubmitFilter(formData);
  };

  const handleFormClear = () => {
    setValue('name', '');    
    setValue('address', null);
    
  };


  return (
    <div className="base-card client-filter-container">
      <form onSubmit={handleSubmit(onSubmit)} className="clients-filter-form">
        <div className="client-filter-name-container">
          <input
            {...register('name')}
            type="text"
            className="form-control"
            placeholder="Nome do Cliente"
            name="name"
          />
          <button className="client-filter-search-icon">
            <SearchIcon />
          </button>
        </div>
        <div className="client-filter-bottom-container">
                 
          <button
            onClick={handleFormClear}
            className="btn btn-outline-secondary btn-client-filter-clear"
          >
            LIMPAR
          </button>
        </div>
      </form>
    </div>
  );
};
export default ClientFilter;
