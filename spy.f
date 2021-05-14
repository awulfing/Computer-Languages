      program Superspy
      implicit none
      integer :: hatsize,t,h
      write(*,*)'Hat Size?'
      read(*,*)hatsize
      t = mod((hatsize/10),10)
      h = mod((hatsize/100),10)
      write (*,*)'Use',t*10+h
      end
