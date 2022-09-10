import axios from "axios";
import { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { Missoes } from "../../models/missoes";
import { BASE_URL } from "../../utils/request";
import NotificationButton from '../NotificationButton';
import './styles.css';

function SalesCard() {

    const min = new Date(new Date().setDate(new Date().getDate() - 365));
    const max = new Date();

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    const [missoes, setMissoes] = useState<Missoes[]>([]);


    useEffect(() => {

        const dmin = minDate.toISOString().slice(0, 10);
        const dmax = maxDate.toISOString().slice(0, 10);

        axios.get(`${BASE_URL}/missoes?minDate=${dmin}&maxDate=${dmax}`).then(response => {
            setMissoes(response.data.content);
        })
    }, [minDate, maxDate]);

    return (
        <>
            <div className="dsmeta-card">
                <h2 className="dsmeta-sales-title">Vendas</h2>
                <div>
                    <div className="dsmeta-form-control-container">
                        <DatePicker
                            selected={minDate}
                            onChange={(date: Date) => setMinDate(date)}
                            className="dsmeta-form-control"
                            dateFormat="dd/MM/yyyy"
                        />                    </div>
                    <div className="dsmeta-form-control-container">
                        <DatePicker
                            selected={maxDate}
                            onChange={(date: Date) => setMaxDate(date)}
                            className="dsmeta-form-control"
                            dateFormat="dd/MM/yyyy"
                        />                    </div>
                </div>

                <div>
                    <table className="dsmeta-sales-table">
                        <thead>
                            <tr>
                                <th className="show992">ID</th>
                                <th className="show576">Data</th>
                                <th>Nome do Ofertante</th>
                                <th className="show992">Local da Missão</th>
                                <th className="show992">Contribuição</th>
                                <th>Total</th>
                                <th>Notificar</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                missoes.map(missoes => {
                                    return (
                                        <tr key={missoes.id}>
                                            <td className="show992">{missoes.id}</td>
                                            <td className="show576">{new Date(missoes.date).toLocaleDateString()}</td>
                                            <td>{missoes.nomeOfertante}</td>
                                            <td className="show992">{missoes.localMissao}</td>
                                            <td className="show992">{missoes.contribuicao}</td>
                                           <td className="show992">R$ {missoes.total.toFixed(2)}</td>
                                            <td>
                                                <div className="dsmeta-red-btn-container">
                                                    <NotificationButton missoesId={missoes.id}/>
                                                </div>
                                            </td>
                                        </tr>
                                    )
                                })
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        </>
    )
}

export default SalesCard;
