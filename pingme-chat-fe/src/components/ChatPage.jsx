import React from 'react'

const ChatPage = () => {
  return (
    <div className=''>
   <header className='dark:border-gray-700 dark:bg-gray-900 py-5 flex justify-around items-center'>
    {/* roomname container */}
    <div>
        <h1 className='text-xl font-semibold'>Room : <span>Family Name</span></h1>
    </div>
    {/* username container */}
    <div>
         <h1 className='text-xl font-semibold'>User : <span>Palak Pant</span></h1>

    </div>
    {/* button: leave room */}
    <div>
    <button className='dark:bg-red-500 dark:hover:bg-red-700 px-3 py-2 rounded-full'>Leave Room</button>

    </div>
    </header>
  </div>
  )
}

export default ChatPage