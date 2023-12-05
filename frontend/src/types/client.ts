import { Address } from 'types/address';

export type Client = {
  id: number;
  name: string;
  cpf: string;
  phone: string;
  email: string;

  addresses: Address[];
  
};
