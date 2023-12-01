import { ReactComponent as SearchIcon } from 'assets/images/search-icon.svg';
import { Order } from 'types/order';
import { Controller, useForm } from 'react-hook-form';
import Select from 'react-select';
import { useEffect, useState } from 'react';
import { requestBackend } from 'util/requests';

import './styles.css';

export type OrderFilterData = {
  clientId: string;
  order: Order | null;
};

type Props = {
  onSubmitFilter: (data: OrderFilterData) => void;
};

const OrderFilter = ({ onSubmitFilter }: Props) => {
  const [selectOrders, setSelectOrders] = useState<Order[]>([]);

  const { register, handleSubmit, setValue, getValues, control } =
    useForm<OrderFilterData>();

  const onSubmit = (formData: OrderFilterData) => {
    onSubmitFilter(formData);
  };

  const handleFormClear = () => {
    setValue('clientId', '');
    setValue('order', null);
  };

  // const handleChangeCategory = (value: Order) => {
  //   setValue('order', value);

  //   const obj : OrderFilterData = {
  //     clientId: getValues('clientId'),
  //     order: getValues('order'),
  //   };
  //   onSubmitFilter(obj);
  // };

  useEffect(() => {
    requestBackend({
      withCredentials: true,
      url: '/orders',
    }).then((response) => {
      setSelectOrders(response.data.content);
    });
  }, []);

  return (
    <div className="base-card order-filter-container">
      <form onSubmit={handleSubmit(onSubmit)} className="order-filter-form">
        <div className="order-filter-name-container">
          <input
            {...register('clientId')}
            type="text"
            className="form-control"
            placeholder="Nome do cliente"
            name="clientId"
          />
          <button className="order-filter-search-icon">
            <SearchIcon />
          </button>
        </div>
        <div className="order-filter-bottom-container">
        {/* <div className="order-filter-category-container">
            <Controller
              name="order"
              control={control}
              render={({ field }) => (
                <Select
                  {...field}
                  options={selectCategories}
                  isClearable
                  placeholder="Order"
                  classNamePrefix="order-filter-select"
                  onChange={(value) => handleChangeCategory(value as Order)}
                  getOptionLabel={(order: Order) =>order.totalOrder}
                  getOptionValue={(order: Order) => String(order.id)}
                />
              )}
            />
          </div> */}
          <button
            onClick={handleFormClear}
            className="btn btn-outline-secondary btn-order-filter-clear"
          >
            LIMPAR
          </button>
        </div>
      </form>
    </div>
  );
};
export default OrderFilter;
