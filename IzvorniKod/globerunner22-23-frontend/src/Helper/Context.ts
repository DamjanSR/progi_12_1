
import {createContext} from 'react';


export const UserContext = createContext({
    user : { username: '', auth: false },
    login : (usename : string)=>{},
    logout : ()=>{}});//nije koisten xD
