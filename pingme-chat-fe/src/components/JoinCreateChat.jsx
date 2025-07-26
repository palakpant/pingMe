import React from 'react'
import speakIcon from '../assets/speak.png'

const JoinCreateChat = () => {
  return (
    
    <div className="min-h-screen flex items-center justify-center">
      <div className='p-10 dark:border-gray-700 w-full flex flex-col gap-5 max-w-md rounded dark:bg-gray-900 shadow'>

        <div>
          <img src={speakIcon} alt="Logo" className="w-24 h-24 mx-auto mb-4" />
        </div>
    <h1 className="text-2xl font-semibold text-center">Join or Create a Chat</h1>
    
    {/* name of user */}
    <div className="">
    <label htmlFor="name" className="block font-medium mb-2">Your Name
    </label>
    <input type="text" id="name" className="w-full dark:bg-gray-600 px-4 py-2 border dark:border-gray-600 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"></input>
    </div>

     {/* room id in div */}
     <div className="">
    <label htmlFor="name" className="block font-medium mb-2">Room Id / New Room Id
    </label>
    <input type="text" id="name" className="w-full dark:bg-gray-600 px-4 py-2 border dark:border-gray-600 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"></input>
    </div>

    {/* button to join room */}
    <div className='flex justify-center gap-2'>
      <button className='px-3 py-2 dark:bg-blue-500 dark:hover:bg-blue-700 rounded-full'>Join Room</button>
    

    {/*create new room */}
    <button className='px-3 py-2 dark:bg-orange-500 dark:hover:bg-orange-700 rounded-full'>Create Room</button>
    </div>

    </div>
    </div>
  )
}

export default JoinCreateChat