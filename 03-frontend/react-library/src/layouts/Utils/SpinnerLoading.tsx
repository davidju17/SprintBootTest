// This spinner is used to show a loading state while data is being fetched

export const SpinnerLoading = () => {
    return (
        <div className='container m-5 d-flex justify-content-center' 
            style={{ height: 550 }}>
                <div className='spinner-border text-primary' role='status'>
                    <span className='visually-hidden'>
                        Loading...
                    </span>
                </div>
        </div>
    );
}