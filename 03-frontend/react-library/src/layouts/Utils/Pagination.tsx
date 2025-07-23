export const Pagination: React.FC<{currentPage: number, totalPages: number, paginate: any}> = (props) => {

        const pageNumbers = [];

        // If we're on the first page
        if (props.currentPage === 1 ) 
        {
            // Always show the current page
            pageNumbers.push(props.currentPage);
            // Show next page if it exists
            if (props.totalPages >= props.currentPage + 1)
            {
            pageNumbers.push(props.currentPage + 1);
            }
            // Show the page after next if it exists
            if (props.totalPages >= props.currentPage + 2)
            {
            pageNumbers.push(props.currentPage + 2);
            }
        } 
        // If we're beyond the first page
        else if (props.currentPage > 1)
        {
            // If we're at least on the third page, show two previous pages
            if (props.currentPage >= 3 ) 
            {
            pageNumbers.push(props.currentPage - 2);
            pageNumbers.push(props.currentPage - 1);
            } 
            // If we're on the second page, show only the previous page
            else
            {
            pageNumbers.push(props.currentPage - 1);
            }

            // Always show the current page
            pageNumbers.push(props.currentPage);
            
            // Show next page if it exists
            if (props.totalPages >= props.currentPage + 1)
            {
            pageNumbers.push(props.currentPage + 1);        
            }
            // Show the page after next if it exists
            if (props.totalPages >= props.currentPage + 2)
            {
            pageNumbers.push(props.currentPage + 2);
            }
        }

        return (
            <nav aria-label="...">
                <ul className='pagination'>
                    <li className='page-item' onClick={() => props.paginate(1)}>
                        <button className='page-link'>
                            First Page
                        </button>
                    </li>
                    {pageNumbers.map(number => (
                        <li key={number} onClick={() => props.paginate(number)} 
                            className={'page-item ' + (props.currentPage === number ? 'active' : '')}>
                                <button className='page-link'>
                                    {number}
                                </button>
                        </li>
                    ))}
                    <li className='page-item' onClick={() => props.paginate(props.totalPages)}>
                        <button className='page-link'>
                            Last Page
                        </button>
                    </li>
                </ul>
            </nav>
        );
      }