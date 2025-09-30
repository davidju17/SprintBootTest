import { useAuth0 } from "@auth0/auth0-react";
import { CardElement, useElements, useStripe } from '@stripe/react-stripe-js';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import PaymentInfoRequest from '../../models/PaymentInfoRequest';
import { SpinnerLoading } from '../Utils/SpinnerLoading';

export const PaymentPage = () => {
    
    const { isAuthenticated, getAccessTokenSilently } = useAuth0();
    const [httpError, setHttpError] = useState(false);
    const [submitDisabled, setSubmitDisabled] = useState(false);
    const [fees, setFees] = useState(0);
    const [loadingFees, setLoadingFees] = useState(true);

    useEffect(() => {
        const fetchFees = async () => {
            if (isAuthenticated) {
                const accessToken = await getAccessTokenSilently();
                const url = `${process.env.REACT_APP_API}/payment/secure/fees`;
                const requestOptions = {
                    method: 'GET',
                    headers: { 
                        Authorization: `Bearer ${accessToken}`,
                        'Content-Type': 'application/json'
                     }
                };
                const paymentResponse = await fetch(url, requestOptions);
                if (!paymentResponse.ok) {
                    throw new Error('Something went wrong!')
                }
                const fees = await paymentResponse.json();
                setFees(fees);
                setLoadingFees(false);
            }
        }
        fetchFees().catch((error: any) => {
            setLoadingFees(false);
            setHttpError(error.message);
        })
    }, [ isAuthenticated, getAccessTokenSilently]);

    if (loadingFees) {
        return (
            <SpinnerLoading/>
        )
    }

    if (httpError) {
        return (
            <div className='container m-5'>
                <p>{httpError}</p>
            </div>
        )
    }


    return(
        <div className='container'>
            {fees > 0 && <div className='card mt-3'>
                <h5 className='card-header'>Fees pending: <span className='text-danger'>${fees}</span></h5>
                <div className='card-body'>
                    <h5 className='card-title mb-3'>Credit Card</h5>
                    <CardElement id='card-element' />
                    <button disabled={submitDisabled} type='button' className='btn btn-md main-color text-white mt-3'
                    >
                        Pay fees
                    </button>
                </div>
            </div>}

            {fees === 0 && 
                <div className='mt-3'>
                    <h5>You have no fees!</h5>
                    <Link type='button' className='btn main-color text-white' to='/search'>
                        Explore top books
                    </Link>
                </div>
            }
            {submitDisabled && <SpinnerLoading/>}
        </div>
    );
}