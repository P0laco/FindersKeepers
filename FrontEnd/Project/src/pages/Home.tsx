import React from 'react';
import { useNavigate } from 'react-router-dom';
import Carousel from '../components/Carousel';
import Header from '../components/Header';

export default function Home() {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen">
      <Header />
      <Carousel />
      
      <div className="absolute inset-0 flex items-center justify-center">
        <div className="max-w-2xl text-center text-white p-8">
          <h1 className="text-5xl font-bold mb-6">Find Your Sports Buddy Today</h1>
          <p className="text-xl mb-8">
            Join Active Buddies to discover and participate in local sports events. 
            Whether you're looking for a football match, basketball game, or tennis partner, 
            we've got you covered.
          </p>
          <button
            onClick={() => navigate('/activities')}
            className="px-8 py-4 bg-blue-600 text-white rounded-lg text-lg font-semibold
                     hover:bg-blue-700 transition-colors transform hover:scale-105"
          >
            Explore Activities
          </button>
        </div>
      </div>
    </div>
  );
}