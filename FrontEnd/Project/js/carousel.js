const images = [
    'https://images.unsplash.com/photo-1574629810360-7efbbe195018?auto=format&fit=crop&q=80',
    'https://images.unsplash.com/photo-1541534741688-6078c6bfb5c5?auto=format&fit=crop&q=80'
];

function initCarousel() {
    const container = document.querySelector('.carousel-slides');
    
    images.forEach((src, index) => {
        const slide = document.createElement('div');
        slide.className = `carousel-slide ${index === 0 ? 'active' : ''}`;
        
        const img = document.createElement('img');
        img.src = src;
        img.alt = `Slide ${index + 1}`;
        
        slide.appendChild(img);
        container.appendChild(slide);
    });

    let currentSlide = 0;
    
    setInterval(() => {
        const slides = document.querySelectorAll('.carousel-slide');
        slides[currentSlide].classList.remove('active');
        currentSlide = (currentSlide + 1) % slides.length;
        slides[currentSlide].classList.add('active');
    }, 5000);
}

document.addEventListener('DOMContentLoaded', initCarousel);